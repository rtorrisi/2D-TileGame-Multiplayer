package dev.tilegame.net.bot;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.GetFile;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.File;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.PhotoSize;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class TelegramBot extends TelegramLongPollingBot {
	private String BOT_USERNAME;
	private String BOT_TOKEN;
	
	public TelegramBot(String username, String token) {
		BOT_USERNAME = username;
		BOT_TOKEN = token;
		
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
	    try { telegramBotsApi.registerBot(this);
		} catch (TelegramApiRequestException e) {}
	    System.out.println(BOT_USERNAME+" avviato.");
	}
	
	@Override
	public String getBotToken() { return BOT_TOKEN; }
	public String getBotUsername() { return BOT_USERNAME; }
	public void onUpdateReceived(Update update) {
		
		if(update.hasMessage()) {
	    	
	        Message message = update.getMessage();
	        	
	        	if (message.getPhoto()!=null) {
	        		List<PhotoSize> photos = message.getPhoto();
	        		GetFile getFileRequest = new GetFile();
	        		getFileRequest.setFileId(photos.get(photos.size()-1).getFileId());
	        		try { saveImage(getFileRequest);
					} catch (TelegramApiException e) {
					} catch (IOException e) {}
	        	}
	        	
	            if(message.hasText()){
	            	//String mess = message.getText().toLowerCase();
	            	/*
	            	SendMessage sendMessageRequest = new SendMessage();
	            	sendMessageRequest.setChatId(message.getChatId().toString());
	            	sendMessageRequest.setText("you said: " + message.getText());
	            	try {sendMessage(sendMessageRequest);
					} catch (TelegramApiException e) {}
					*/
	            }
	    }
	}

	public void saveImage(GetFile fileRequest) throws TelegramApiException, IOException {
		File file = getFile(fileRequest);		
		String destinationFile = "Data/File/Images/img" + file.getFilePath().substring("photo/file".length());
		URL url = new URL("https://api.telegram.org/file/bot"+BOT_TOKEN+"/"+file.getFilePath());
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) os.write(b, 0, length);

		is.close();
		os.close();
	}
	
	public void sendNewImage(String chatId, String imagePath) throws TelegramApiException, IOException {
		SendPhoto sendPhotoRequest = new SendPhoto();
		sendPhotoRequest.setChatId(chatId);
		
		InputStream is = new BufferedInputStream(new FileInputStream(imagePath));
    	sendPhotoRequest.setNewPhoto("botimage.jpg", is);
		sendPhoto(sendPhotoRequest);
		is.close();
	}
	
	public void sendImageById(String chatId, String image_id) throws TelegramApiException {
		SendPhoto sendPhotoRequest = new SendPhoto();
		sendPhotoRequest.setChatId(chatId);
    	sendPhotoRequest.setPhoto(image_id);
		sendPhoto(sendPhotoRequest);
	}

	public void sendMess(String text, String chat_id) {
		SendMessage sendMessageRequest = new SendMessage();
    	sendMessageRequest.setChatId(chat_id);
    	sendMessageRequest.setText(text);
		try { sendMessage(sendMessageRequest);
		} catch (TelegramApiException e) {}
	}
}