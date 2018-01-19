package com.example.administrator.bbchatuiautomator;

import android.app.UiAutomation;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/1 0001.
 */

public class UiTest extends UiAutomatorTestCase {

    final static int TXT=0;//文本
    final static int SMAILE=1;//表情
    final static int IMG=2;//图片
    final static int BURNTXT=3;//阅后即焚文本
    final static int BURNSMAILE=4;//阅后即焚表情
    final static int BURNIMG=5;//阅后即焚图片
    final static int Voice=6;//语音
    final static int BURNsendVoice=7;//阅后即焚语音
    final static int SHOTTXT=8;//防截屏文本
    final static int SHOTSMAILE=9;//防截屏表情
    final static int SHOTIMG=10;//防截屏图片
    final static int card=11;//名片
    final static int file=12;//文件
    final static int report=13;//汇报
    final static int calendar=14;//日历
    final static int Signin=15;//签到
    final static int location=16;//位置
    final static int examination_approval=17;//审批
    final static int si_but=18;//创建私有群
    final static int gong_but=19;//创建公开群

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
//        appViews.scrollForward();
        UiObject Calculator = new UiObject(new UiSelector().index(17));
        Calculator.clickAndWaitForNewWindow();
        Thread.sleep(4000);
        UiObject button2=new UiObject(new UiSelector().resourceId("android:id/button2"));//更新取消按钮
        if (button2.exists()){
            button2.clickAndWaitForNewWindow();
        }
//        CreateGroup(si_but);
//        CreateGroup(gong_but);
        UiObject main_tab_stagebutton=new UiObject(new UiSelector().text("联系人"));//首页按钮
        if (main_tab_stagebutton.exists()){
            main_tab_stagebutton.clickAndWaitForNewWindow();
        UiObject circle_list=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/circle_list"));//联系人页群聊按钮
        if (circle_list.exists()){
            circle_list.clickAndWaitForNewWindow();
            bbChat(chatGrop,"投票测试群");
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
                    boolean ismsg=false;
                    for (int i=0;i<=20;i++){
                        group_Voting(ismsg);
                    }

//                  try {
//                    send_Burn(null,TXT);
//                    send_Burn(null,SMAILE);
//                    send_Burn(null,IMG);
//                    send_Burn(null,Voice);
//                    send_Burn("5秒",BURNTXT);
//                    send_Burn("10秒",BURNTXT);
//                    send_Burn("30秒",BURNTXT);
//                    send_Burn("1分钟",BURNTXT);
//                    send_Burn("5秒",BURNSMAILE);
//                    send_Burn("10秒",BURNSMAILE);
//                    send_Burn("30秒",BURNSMAILE);
//                    send_Burn("1分钟",BURNSMAILE);
//                    send_Burn(null,SHOTTXT);
//                    send_Burn(null,SHOTSMAILE);
//                    send_Burn(null,SHOTIMG);
//
//                        send_Burn(null,Signin);
//                        send_Burn(null,location);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
//                break;
        }
    }

    /**
     * 发送语音
     * @throws UiObjectNotFoundException
     */
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
            if (button_message_send.exists()){
                button_message_send.click();
            }else {
                break;
            }

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
        UiObject easy_progress_bar=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/easy_progress_bar"));
        galleryid.click();
        isselected1.click();
        isselected2.click();
        buttonphotoSend.click();
        if (easy_progress_bar.exists()){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 阅后即焚
     * @param s 设置秒数 5s 10s 30s 1m
     * @throws UiObjectNotFoundException
     */
    public void send_Burn(String s,int type ) throws UiObjectNotFoundException, InterruptedException {
        UiObject  filedirctoryid=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/filedirctoryid"));
        UiObject fileselectsend=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/fileselectsend"));
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
                send_burn.clickAndWaitForNewWindow(3000);
                UiScrollable scrollable= new UiScrollable(new UiSelector().resourceId("com.anbang.bbchat:id/wheel_view_wv1"));
                setTime(s);
                tv_ok.clickAndWaitForNewWindow();
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
//                shot_smaile.click();
                sendSmaile();
                break;
            case SHOTIMG:
                UiObject shot_img=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/shot"));
//                shot_img.click();
                sendImg();
                break;
            case card://名片
                filedirctoryid.click();
                fileselectsend.getChild(new UiSelector().index(0)).click();
                UiObject lv_contact=new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/lv_contact"));
                lv_contact.getChild(new UiSelector().index(0)).click();
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/positiveButton")).clickAndWaitForNewWindow();
                break;
            case file://文件
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                fileselectsend.getChild(new UiSelector().index(1)).click();
                break;
            case report://汇报
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                break;
            case calendar://日历
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                break;
            case Signin://签到
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                fileselectsend.getChild(new UiSelector().index(4)).click();
                Thread.sleep(3000);
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/et_sign_backup")).setText("测试签到");
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/gv_cc")).getChild(new UiSelector().index(0)).click();
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_friend")).clickAndWaitForNewWindow();
               UiObject recycler_contact= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/recycler_contact"));
                recycler_contact.getChild(new UiSelector().index(0)).click();
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/btn_submit")).clickAndWaitForNewWindow();
                new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/btn_sign")).clickAndWaitForNewWindow();
                break;
            case location://位置
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                fileselectsend.getChild(new UiSelector().index(5)).click();
                Thread.sleep(3000);
               UiObject listView= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/listView"));
               UiObject title_right_btn= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/title_right_btn"));
                if (listView.getChildCount()>1){
                    title_right_btn.click();
                }
                break;
            case examination_approval://审批
                if (!fileselectsend.exists()){
                    filedirctoryid.click();
                }
                break;

        }
    }
    public void setTime(String s) throws UiObjectNotFoundException {
        UiScrollable scrollable_smaile= new UiScrollable(new UiSelector().text("5秒"));
        if (s.equals("30秒")){
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }else if (s.equals("5秒")){
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
        }else if (s.equals("10秒")){
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }else if (s.equals("1分钟")){
            scrollable_smaile.setAsVerticalList();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
            scrollable_smaile.scrollForward();
        }
    }

    public void CreateGroup(int type) throws UiObjectNotFoundException {
        //首页+号
        UiObject title_right_img_btn= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/title_right_img_btn"));
        title_right_img_btn.click();
        //发起群聊
        UiObject prompt_item= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/prompt_item"));

        UiObject gong= new UiObject(new UiSelector().text("公开群"));
        prompt_item.click();
        switch (type){
            case si_but:
                UiObject si= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/si"));
                si.click();
                break;
            case gong_but:
                gong.click();
                break;
        }
        //私有群

        //联系人listview
        UiObject country_lvcountry= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/country_lvcountry"));
        UiObject title_right_btn= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/title_right_btn"));
        int count=country_lvcountry.getChildCount()-1;
        for (int i=0;i<count;i++){
            if (count>2){
                country_lvcountry.getChild(new UiSelector().index(i)).click();
            }else {

            }
        }
        title_right_btn.clickAndWaitForNewWindow();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getUiDevice().pressBack();
    }

    /**
     *   群投票
     * @throws UiObjectNotFoundException
     */
    public void group_Voting(boolean ismsg) throws UiObjectNotFoundException {
        // 点击群详情
        UiObject country_lvcountry= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/title_right_img_btn"));
        country_lvcountry.click();
        //群投票
        UiObject Voting= new UiObject(new UiSelector().text("群投票"));
        Voting.click();
        UiObject release_Voting= new UiObject(new UiSelector().text("发布投票"));
        if (release_Voting.exists()){
            release_Voting.click();
        }

        //投票标题
        UiObject et_title= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/et_title"));
        et_title.setText("测试投票");
        if (ismsg) {
            //点击是否添加照片
            UiObject switch_photo = new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/switch_photo"));
            switch_photo.click();
            //点击添加照片
            UiObject tv_add_option = new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/tv_add_option"));
            if (tv_add_option.exists()) {
                tv_add_option.click();
            }
            //照片列表
            UiObject listview = new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/listview"));
            listview.getChild(new UiSelector().index(0)).click();
            //照片展示列表
            UiObject gridview = new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/gridview"));


            UiObject t1 = gridview.getChild(new UiSelector().index(0)).getChild(new UiSelector().index(1));
            ;
            t1.click();
            UiObject t2 = gridview.getChild(new UiSelector().index(1)).getChild(new UiSelector().index(1));
            t2.click();
            UiObject t3 = gridview.getChild(new UiSelector().index(2)).getChild(new UiSelector().index(1));
            t3.click();
            UiObject t4 = gridview.getChild(new UiSelector().index(3)).getChild(new UiSelector().index(1));
            t4.click();
            UiObject t5 = gridview.getChild(new UiSelector().index(4)).getChild(new UiSelector().index(1));
            t5.click();
            UiObject t6 = gridview.getChild(new UiSelector().index(5)).getChild(new UiSelector().index(1));
            t6.click();
            //选择图片后点击确定
            UiObject confirm_tv = new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/confirm_tv"));
            confirm_tv.clickAndWaitForNewWindow();

        }else if (!ismsg){
          UiObject tv_add_option=  new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/tv_add_option"));
            tv_add_option.click();
            tv_add_option.click();
            tv_add_option.click();
            tv_add_option.click();

            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(0)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项一");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(1)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项二");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(2)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项3");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(3)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项4");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(4)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项5");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/ll_container"))
                    .getChild(new UiSelector().index(5)).getChild(new UiSelector()
                    .resourceId("com.anbang.bbchat:id/et_content")).setText("测试投票选项6");
        }
            //是否多选
            UiObject switch_multiSelected= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/switch_multiSelected"));
            switch_multiSelected.click();
            UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));
            appViews.setAsVerticalList();
            appViews.scrollForward();
           //是否记名
            UiObject switch_signname= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/switch_signname"));
            switch_signname.click();
            UiObject tv_end_time= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/endTimeLayout"));
            tv_end_time.click();

            //滑动小时
            new UiScrollable(new UiSelector().resourceId("com.anbang.bbchat:id/hour")).setAsVerticalList().scrollForward();




             new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/positiveButton")).click();
             new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/et_describe")).setText("测试投票描述");
            new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/publish")).click();
        UiObject chat_messages= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/chat_messages")).getChild(new UiSelector().index(1));
        chat_messages.getChild(new UiSelector().resourceId("com.anbang.bbchat:id/linearLayout1")).click();
//        UiObject text_content1= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/text_content1"));
//        UiObject imageView11= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/imageView11"));

        UiObject group_vote_result= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/group_vote_result"));

        group_vote_result.getChild(new UiSelector().index(0)).getChild(new UiSelector().index(0)).click();
        group_vote_result.getChild(new UiSelector().index(1)).getChild(new UiSelector().index(1)).click();
        UiObject btn_vote= new UiObject(new UiSelector().resourceId("com.anbang.bbchat:id/btn_vote"));
        btn_vote.click();
        getUiDevice().pressBack();
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
