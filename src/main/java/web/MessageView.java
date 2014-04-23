/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.Message;
import ejb.MessageFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ferrycode
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    @EJB
    private MessageFacadeLocal messageFacade;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new Message();
    }
    // Creates a new field
    private Message message;


    // Calls getMessage to retrieve the message
    public Message getMessage() {
       return message;
    }

    // Returns the total number of messages
    public int getNumberOfMessages(){
       return messageFacade.findAll().size();
    }

    // Saves the message and then returns the string "theend"
    public String postMessage(){
       this.messageFacade.create(message);
       return "theend";
    }
}
