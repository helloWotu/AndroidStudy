package com.example.coolweather.gson;

import java.util.List;

public class Weather {

    /**
     * code : 10000
     * message : success
     * result : {"dataList":[[{"title":"我的订阅","icon":"http://img.kaolafm.net/icon/personalcenter/subscribe@2x.png","type":0},{"title":"我的历史","icon":"http://img.kaolafm.net/icon/personalcenter/history@2x.png","type":1},{"title":"我赞过的","icon":"http://img.kaolafm.net/icon/personalcenter/praise@2x.png","type":3}],[{"title":"我的账户","icon":"http://img.kaolafm.net/icon/personalcenter/account@2x.png","type":4},{"title":"我要直播","icon":"http://img.kaolafm.net/icon/personalcenter/live@2x.png","type":5},{"title":"设置","icon":"http://img.kaolafm.net/icon/personalcenter/setting@2x.png","type":6}]]}
     * serverTime : 1552635938976
     */

    private String code;
    private String message;
    private ResultBean result;
    private long serverTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public static class ResultBean {
        private List<List<DataListBean>> dataList;

        public List<List<DataListBean>> getDataList() {
            return dataList;
        }

        public void setDataList(List<List<DataListBean>> dataList) {
            this.dataList = dataList;
        }

        public static class DataListBean {
            /**
             * title : 我的订阅
             * icon : http://img.kaolafm.net/icon/personalcenter/subscribe@2x.png
             * type : 0
             */

            private String title;
            private String icon;
            private int type;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
