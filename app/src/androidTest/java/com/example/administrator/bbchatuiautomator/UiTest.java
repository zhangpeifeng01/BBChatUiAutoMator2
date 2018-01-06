package com.example.administrator.bbchatuiautomator;

import android.app.UiAutomation;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

/**
 * Created by Administrator on 2018/1/1 0001.
 */

public class UiTest extends UiAutomatorTestCase {
    /**
     * 单聊
     */
    final static int chat=0;
    /**
     * 群聊
     */
    final static int chatGrop=1;
    public void testDemo() throws UiObjectNotFoundException, InterruptedException {
        getUiDevice().pressHome();//点击home
        //滑动
        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
        appViews.setAsHorizontalList();
        appViews.scrollForward();
        appViews.scrollForward();

        UiObject Calculator = new UiObject(new UiSelector().index(16));
        Calculator.clickAndWaitForNewWindow();
        Thread.sleep(4000);
        UiObject button2=new UiObject(new UiSelector().resourceId("android:id/button2"));//更新取消按钮
        if (button2.exists()){
            button2.clickAndWaitForNewWindow();
        }
        UiObject main_tab_stagebutton=new UiObject(new UiSelector().text("联系人"));//首页按钮
        if (main_tab_stagebutton.exists()){
            main_tab_stagebutton.clickAndWaitForNewWindow();

        UiObject circle_list=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/circle_list"));//联系人页群聊按钮
        if (circle_list.exists()){
            circle_list.clickAndWaitForNewWindow();
            bbChat(chatGrop,"邦邦社区测试");
        }
    }


        getUiDevice().pressBack();
    }

    /**
     *
     * @param type 聊天类型：单聊、群聊
     * @param name 聊天对象名称
     * @throws UiObjectNotFoundException
     */
    public void bbChat(int type,String name) throws UiObjectNotFoundException {

        switch (type){
            case chat:

                break;
            case chatGrop:
                UiObject filter_edit=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/filter_edit"));//查找收索
                if (filter_edit.exists()){
                    filter_edit.setText(name);
                    UiObject ll_group_list=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/lv_listView"));
                    UiObject group_title=ll_group_list.getChild(new UiSelector().index(0));
                    group_title.clickAndWaitForNewWindow();
//                    sendSmaile();
                    sendText();
                }
                break;
        }
    }

    /**
     * 发送文本消息
     * @throws UiObjectNotFoundException
     */
    public void sendText() throws UiObjectNotFoundException {

        UiObject chat_input=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/chat_input"));//输入
        UiObject button_message_send=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/button_message_send"));
        for (int i=0;i<10;i++){
            chat_input.setText("UiAuot测试"+i);
            button_message_send.click();
        }
    }

    /**
     * 发送小表情
     */
    public void sendSmaile(){
        UiObject smailefaceid=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/smailefaceid"));
        UiObject face_gridview_id=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/face_gridview_id"));
        UiObject button_message_send=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/button_message_send"));
        if (smailefaceid.exists()){
            try {
                smailefaceid.click();
                int childCount = face_gridview_id.getChildCount()-1;
                for (int i=0;i<=childCount;i++){
                    face_gridview_id.getChild(new UiSelector().index(i)).click();
                    button_message_send.click();
                }
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }


        }
        getUiDevice().pressBack();
    }
}
