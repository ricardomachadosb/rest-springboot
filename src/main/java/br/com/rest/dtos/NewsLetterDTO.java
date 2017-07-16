package br.com.rest.dtos;

import java.util.List;

public class NewsLetterDTO {
	private String recipient;
	
	private List<NewsLetterNotificationDTO> notifications;

	public NewsLetterDTO(String recipient, List<NewsLetterNotificationDTO> notifications) {
		this.recipient = recipient;
		this.notifications = notifications;
	}
	
	public NewsLetterDTO(String recipient) {
		this.recipient = recipient;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public List<NewsLetterNotificationDTO> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NewsLetterNotificationDTO> notifications) {
		this.notifications = notifications;
	}
	
	
}
