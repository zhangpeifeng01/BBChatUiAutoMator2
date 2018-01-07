package com.example.administrator.bbchatuiautomator;

import android.app.UiAutomation;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/1 0001.
 */

public class UiTest extends UiAutomatorTestCase {

    final static int TXT=0;
    final static int SMAILE=1;
    final static int IMG=2;
    final static int BURNTXT=3;
    final static int BURNSMAILE=4;
    final static int BURNIMG=5;
    final static int Voice=6;
    final static int BURNsendVoice=7;
    final static int SHOTTXT=8;
    final static int SHOTSMAILE=9;
    final static int SHOTIMG=10;
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
                    sendVoice();
//                    send_Burn(null,TXT);
//                    send_Burn(null,SMAILE);
//                    send_Burn(null,IMG);
//                    send_Burn("5秒",BURNTXT);
//                    send_Burn("10秒",BURNTXT);
//                    send_Burn("30秒",BURNTXT);
//                    send_Burn("1分",BURNTXT);
//                    send_Burn("5秒",BURNSMAILE);
//                    send_Burn("10秒",BURNSMAILE);
//                    send_Burn("30秒",BURNSMAILE);
//                    send_Burn("1分",BURNSMAILE);
                }
                break;
        }
    }
 public void sendVoice() throws UiObjectNotFoundException {
     UiObject speakerid=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/speakerid"));//输入
     UiObject edit_work_record_coltor=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/edit_work_record_coltor"));//输入
     speakerid.click();
     longClick(getUiDevice(),edit_work_record_coltor,800);

 }
    /**
     * 发送文本消息
     * @throws UiObjectNotFoundException
     */
    public void sendText() throws UiObjectNotFoundException {

        UiObject chat_input=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/chat_input"));//输入
        UiObject button_message_send=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/button_message_send"));
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
        for (int i=0;i<5;i++){

            chat_input.setText("测试"+ df.format(new Date()));
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
                for (int i=0;i<=5;i++){
                    face_gridview_id.getChild(new UiSelector().index(i)).click();
                    button_message_send.click();
                }
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }


        }
        getUiDevice().pressBack();
    }

    /**
     * 发送图片
     * @throws UiObjectNotFoundException
     */
    public void sendImg() throws UiObjectNotFoundException {
        UiObject galleryid=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/galleryid"));
        UiObject horzontalistview=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/horzontalistview"));
        UiObject isselected1=horzontalistview.getChild(new UiSelector().index(1)).getChild(new UiSelector().index(1));
        UiObject isselected2=horzontalistview.getChild(new UiSelector().index(2)).getChild(new UiSelector().index(1));
        UiObject buttonphotoSend=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/buttonphotoSend"));
        galleryid.click();
        isselected1.click();
        isselected2.click();
        buttonphotoSend.click();

    }


    /**
     * 阅后即焚
     * @param s 设置秒数 5s 10s 30s 1m
     * @throws UiObjectNotFoundException
     */
    public void send_Burn(String s,int type ) throws UiObjectNotFoundException {
        switch (type){
            case TXT:
                sendText();
                break;
            case SMAILE:
                sendSmaile();
                break;
            case IMG:
                sendImg();
                break;
            case Voice:
                sendVoice();
                break;
            case BURNTXT:
                UiObject send_burn=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/send_burn"));
                UiObject tv_ok=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/tv_ok"));
                send_burn.click();
                UiScrollable scrollable= new UiScrollable(new UiSelector().resourceId("com.anbang.bbchat:id/wheel_view_wv1"));
                tv_ok.clickAndWaitForNewWindow();
                setTime(s);
                sendText();
                break;
            case BURNSMAILE:
                UiObject send_burn_smaile=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/send_burn"));
                UiObject tv_ok_smaile=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/tv_ok"));
                send_burn_smaile.click();
                setTime(s);
                tv_ok_smaile.clickAndWaitForNewWindow();
                sendSmaile();
                break;
            case BURNIMG:
                sendImg();
                setTime(s);
                break;
            case BURNsendVoice:
                UiObject send_burn_Voice=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/send_burn"));
                UiObject tv_ok_Voice=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/tv_ok"));
                send_burn_Voice.click();
                setTime(s);
                tv_ok_Voice.clickAndWaitForNewWindow();
                sendVoice();
                break;
            case SHOTTXT:
                UiObject shot_txt=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/shot"));
                shot_txt.click();
                sendText();
                break;
            case SHOTSMAILE:
                UiObject shot_smaile=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/shot"));
                shot_smaile.click();
                sendSmaile();
                break;
            case SHOTIMG:
                UiObject shot_img=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/shot"));
                shot_img.click();
                sendImg();
                break;


        }
    }
    public void setTime(String s) throws UiObjectNotFoundException {
        if (s.equals("30秒")){
            UiScrollable scrollable_smaile= new UiScrollable(new UiSelector().text("5秒"));
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }else if (s.equals("5秒")){
            UiScrollable scrollable_smaile= new UiScrollable(new UiSelector().text("5秒"));
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
        }else if (s.equals("10秒")){
            UiScrollable scrollable_smaile= new UiScrollable(new UiSelector().text("5秒"));
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }else if (s.equals("1分钟")){
            UiScrollable scrollable_smaile= new UiScrollable(new UiSelector().text("10秒"));
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }
    }
    /**
     * 控件长按操作
     * @param ud
     * @param uiObject
     * @param steps
     * @throws UiObjectNotFoundException
     */
    public  void longClick(UiDevice ud, UiObject uiObject, int steps) throws UiObjectNotFoundException{
        ud.swipe(uiObject.getBounds().centerX(), uiObject.getBounds().centerY(),
                uiObject.getBounds().centerX(), uiObject.getBounds().centerY(), steps);
    }
}
