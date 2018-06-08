package com.example.application.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */

public class NewsBean {

    //头条
    private List<Bean> T1348647909107;

    public List<Bean> getTop() {
        return T1348647909107;
    }

    public void setT1348647909107(List<Bean> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    //nba
    private List<Bean> T1348649145984;

    public List<Bean> getNba() {
        return T1348649145984;
    }

    public void setT1348649145984(List<Bean> T1348649145984) {
        this.T1348649145984 = T1348649145984;
    }

    //笑话
    private List<Bean> T1350383429665;

    public List<Bean> getJoke() {
        return T1350383429665;
    }

    public void setT1350383429665(List<Bean> T1350383429665) {
        this.T1350383429665 = T1350383429665;
    }



    public static class Bean {
        /**
         * template : normal1
         * skipID : 00AP0001|2293713
         * lmodify : 2018-05-22 14:30:16
         * postid : PHOT25VUH000100A
         * source : 视觉中国
         * title : 杭州千名僧人"托钵行脚"募百万善款
         * mtime : 2018-05-22 14:30:16
         * hasImg : 1
         * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
         * digest :
         * photosetID : 00AP0001|2293713
         * boardid : photoview_bbs
         * alias : Top News
         * hasAD : 1
         * imgsrc : http://cms-bucket.nosdn.127.net/10d2012b658c4ca286518170bef1a38c20180522142555.jpeg
         * ptime : 2018-05-22 14:26:24
         * daynum : 17673
         * hasHead : 1
         * imgType : 1
         * order : 1
         * editor : []
         * votecount : 205
         * hasCover : false
         * docid : 9IG74V5H00963VRO_DIDSQCJLlihang1updateDoc
         * tname : 头条
         * priority : 555
         * ads : [{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293694","tag":"photoset","title":"高校异地恋情侣520晒\"拼贴照\"秀恩爱","imgsrc":"bigimg","url":"00AP0001|2293694"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293692","tag":"photoset","title":"卖菜大妈手绘菜单 价格功效一目了然","imgsrc":"bigimg","url":"00AP0001|2293692"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293690","tag":"photoset","title":"姑娘和乞丐私奔 为救重病丈夫卖胎儿","imgsrc":"bigimg","url":"00AP0001|2293690"},{"subtitle":"","skipType":"photoset","skipID":"00AP0001|2293691","tag":"photoset","title":"117名女生\"簇拥\"唯一男生拍毕业照","imgsrc":"bigimg","url":"00AP0001|2293691"},{"subtitle":"","skipType":"photoset","skipID":"00AN0001|2293676","tag":"photoset","title":"嫦娥四号\"鹊桥\"号中继星发射成功","imgsrc":"bigimg","url":"00AN0001|2293676"}]
         * ename : androidnews
         * replyCount : 224
         * imgsum : 6
         * hasIcon : false
         * skipType : photoset
         * cid : C1348646712614
         * url_3w : http://news.163.com/18/0522/08/DID7AD46000189FH.html
         * url : http://3g.163.com/news/18/0522/08/DID7AD46000189FH.html
         * ltitle : 习近平的英雄情怀
         * subtitle :
         * specialID : S1526656059561
         * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/9f5956e8433043f9a3cdab4b59f6050820180522142411.png"},{"imgsrc":"http://cms-bucket.nosdn.127.net/96b191f9dbee4315a734e2a0fde4b1b420180522142411.png"}]
         */

        private String template;
        private String skipID;
        private String lmodify;
        private String postid;
        private String source;
        private String title;
        private String mtime;
        private int hasImg;
        private String topic_background;
        private String digest;
        private String photosetID;
        private String boardid;
        private String alias;
        private int hasAD;
        private String imgsrc;
        private String ptime;
        private String daynum;
        private int hasHead;
        private int imgType;
        private int order;
        private int votecount;
        private boolean hasCover;
        private String docid;
        private String tname;
        private int priority;
        private String ename;
        private int replyCount;
        private int imgsum;
        private boolean hasIcon;
        private String skipType;
        private String cid;
        private String url_3w;
        private String url;
        private String ltitle;
        private String subtitle;
        private String specialID;
        private List<?> editor;
        private List<AdsBean> ads;
        private List<ImgextraBean> imgextra;

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getDaynum() {
            return daynum;
        }

        public void setDaynum(String daynum) {
            this.daynum = daynum;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getUrl_3w() {
            return url_3w;
        }

        public void setUrl_3w(String url_3w) {
            this.url_3w = url_3w;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getLtitle() {
            return ltitle;
        }

        public void setLtitle(String ltitle) {
            this.ltitle = ltitle;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getSpecialID() {
            return specialID;
        }

        public void setSpecialID(String specialID) {
            this.specialID = specialID;
        }

        public List<?> getEditor() {
            return editor;
        }

        public void setEditor(List<?> editor) {
            this.editor = editor;
        }

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public List<ImgextraBean> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraBean> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsBean {
            /**
             * subtitle :
             * skipType : photoset
             * skipID : 00AP0001|2293694
             * tag : photoset
             * title : 高校异地恋情侣520晒"拼贴照"秀恩爱
             * imgsrc : bigimg
             * url : 00AP0001|2293694
             */

            private String subtitle;
            private String skipType;
            private String skipID;
            private String tag;
            private String title;
            private String imgsrc;
            private String url;

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSkipType() {
                return skipType;
            }

            public void setSkipType(String skipType) {
                this.skipType = skipType;
            }

            public String getSkipID() {
                return skipID;
            }

            public void setSkipID(String skipID) {
                this.skipID = skipID;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraBean {
            /**
             * imgsrc : http://cms-bucket.nosdn.127.net/9f5956e8433043f9a3cdab4b59f6050820180522142411.png
             */

            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
