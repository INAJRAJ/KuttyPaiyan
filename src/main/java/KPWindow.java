package com.KP.UI;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.KP.Action.*;

public class KPWindow extends javax.swing.JFrame {

	
	private final static String newline = "\n";
	
	String initialText = "<html>\n" +
             "<font color=red>KP : Hi Welcome</font>\n" +
             "</html>";
	
	public KPWindow() {
		initComponents();
		
		this.setTitle("KP Chat");
	}

    private void initComponents() {

        jTextFieldMessage = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditPaneChat = new javax.swing.JEditorPane();
        jButtonSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
     
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jEditPaneChat.setContentType("text/html");
        jEditPaneChat.setText(initialText);
        jTextFieldMessage.setColumns(60);

        jTextFieldMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMessageKeyTyped(evt);
            }
        });

        jEditPaneChat.setEditable(false);
        jScrollPane1.setViewportView(jEditPaneChat);

        jButtonSend.setText("Send");
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextFieldMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonClear))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSend)
                    .addComponent(jButtonClear)))
        );

        pack();
        jTextFieldMessage.requestFocus();
    }


	
	private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
		
		String temStr = jTextFieldMessage.getText();
		jEditPaneChat.setText(insertintoHTML(temStr,jEditPaneChat.getText(), false));
		temStr = InputGateway.processInput(jTextFieldMessage.getText());
		jEditPaneChat.setText(insertintoHTML(temStr,jEditPaneChat.getText(), true));
		jTextFieldMessage.setText("");
		
	}

	private void jTextFieldMessageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMessageKeyTyped
		if (evt.getKeyChar() == '\n'){
			jButtonSend.doClick();
		}
	}

	private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
		jTextFieldMessage.setText("");
	}

	public static boolean isScrollBarFullyExtended(JScrollBar vScrollBar) {
        BoundedRangeModel model = vScrollBar.getModel();
		int bottomPos = model.getExtent() + model.getValue() + 10;
		int maxPos = model.getMaximum();
        return bottomPos >= maxPos;
    }
	
	public static void scrollToBottom(JComponent component) {
        Rectangle visibleRect = component.getVisibleRect();
        visibleRect.y = component.getHeight() - visibleRect.height;
        component.scrollRectToVisible(visibleRect);
    }
	
	public static String insertintoHTML(String inputStr, String sourceStr, boolean KPFlag){
		
		//if KP is responding it will be true otherwise it will be false
		
		StringBuilder sb = new StringBuilder("<br>");
		if (KPFlag)
				sb.append(  "<font color=red> KP : " );
			else
				sb.append(  "<font color=blue> Myself : " );
		sb.append(inputStr);
		sb.append("</font>");
		int pos = sourceStr.indexOf("</body>");
		
		return(sourceStr.substring(0,pos-1) + sb.toString() + "</body></html>");
	
	}

	

    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private JEditorPane jEditPaneChat;
    private javax.swing.JTextField jTextFieldMessage;

}