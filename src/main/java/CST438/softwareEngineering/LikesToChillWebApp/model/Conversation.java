package CST438.softwareEngineering.LikesToChillWebApp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Conversation {

	private int conversationId;

	private int senderId;
	private int receiverId;
	
	private String messageBody;
	private String timestamp;
	
	
	
	public Conversation() {
		
	}
	
	public Conversation(int conversationId, int senderId, int receiverId, String messageBody, String timestamp) {
		super();
		this.conversationId = conversationId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.messageBody = messageBody;
		this.timestamp = timestamp;
	}

	public int getConversationId() {
		return conversationId;
	}
	
	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}
	
	public int getSenderId() {
		return senderId;
	}
	
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	
	public int getReceiverId() {
		return receiverId;
	}
	
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
	public String getMessageBody() {
		return messageBody;
	}
	
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Conversations [conversationId=" + conversationId + ", senderId=" + senderId + ", receiverId="
				+ receiverId + ", messageBody=" + messageBody + ", timestamp=" + timestamp + "]";
	}	
}
