/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.resources.json;


/**
 *
 * @author anshu
 */
public class JSONMessage {
    private String messageType;     //globally unique message name
    private Integer messageVersion=1;           //message version, positive monotonic integer
    private Integer messageTimeStamp;  //time in seconds since epoch
    private JSONClass messagePayload;
    
  //  private Integer messageID;
  //  private static Integer messageCounter=0;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    
    public JSONClass getMessagePayload() {
        return messagePayload;
    }

    public void setMessagePayload(JSONClass messagePayload) {
        this.messagePayload = messagePayload;
    }

   
    public JSONMessage() {
        this.messageTimeStamp = (int) (System.currentTimeMillis() / 1000L);
    //    this.messageID=++messageCounter;
    }
    
    
    
}
