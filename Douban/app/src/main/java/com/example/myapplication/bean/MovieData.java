package com.example.myapplication.bean;

import java.util.List;

public class MovieData {


    /**
     * count : 20
     * start : 0
     * total : 26
     * subjects : [{"rating":{"max":10,"average":9,"stars":"45","min":0},"genres":["动作","科幻","奇幻"],"title":"复仇者联盟4：终局之战","casts":[{"alt":"https://movie.douban.com/celebrity/1016681/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp"},"name":"小罗伯特·唐尼","id":"1016681"},{"alt":"https://movie.douban.com/celebrity/1017885/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp"},"name":"克里斯·埃文斯","id":"1017885"},{"alt":"https://movie.douban.com/celebrity/1021959/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp"},"name":"克里斯·海姆斯沃斯","id":"1021959"}],"collect_count":174971,"original_title":"Avengers: Endgame","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1321812/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp"},"name":"安东尼·罗素","id":"1321812"},{"alt":"https://movie.douban.com/celebrity/1320870/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp"},"name":"乔·罗素","id":"1320870"}],"year":"2019","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp"},"alt":"https://movie.douban.com/subject/26100958/","id":"26100958"},{"rating":{"max":10,"average":4.8,"stars":"25","min":0},"genres":["爱情"],"title":"比悲伤更悲伤的故事","casts":[{"alt":"https://movie.douban.com/celebrity/1274316/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31663.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31663.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31663.webp"},"name":"陈意涵","id":"1274316"},{"alt":"https://movie.douban.com/celebrity/1326546/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1511061580.88.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1511061580.88.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1511061580.88.webp"},"name":"刘以豪","id":"1326546"},{"alt":"https://movie.douban.com/celebrity/1315045/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31369.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31369.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p31369.webp"},"name":"张书豪","id":"1315045"}],"collect_count":77980,"original_title":"比悲傷更悲傷的故事","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1312860/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44818.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44818.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p44818.webp"},"name":"林孝谦","id":"1312860"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549523952.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549523952.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549523952.webp"},"alt":"https://movie.douban.com/subject/27624661/","id":"27624661"}]
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":9,"stars":"45","min":0}
         * genres : ["动作","科幻","奇幻"]
         * title : 复仇者联盟4：终局之战
         * casts : [{"alt":"https://movie.douban.com/celebrity/1016681/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp"},"name":"小罗伯特·唐尼","id":"1016681"},{"alt":"https://movie.douban.com/celebrity/1017885/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp"},"name":"克里斯·埃文斯","id":"1017885"},{"alt":"https://movie.douban.com/celebrity/1021959/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4053.webp"},"name":"克里斯·海姆斯沃斯","id":"1021959"}]
         * collect_count : 174971
         * original_title : Avengers: Endgame
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1321812/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp"},"name":"安东尼·罗素","id":"1321812"},{"alt":"https://movie.douban.com/celebrity/1320870/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp"},"name":"乔·罗素","id":"1320870"}]
         * year : 2019
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp"}
         * alt : https://movie.douban.com/subject/26100958/
         * id : 26100958
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 9
             * stars : 45
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552058346.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1016681/
             * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp"}
             * name : 小罗伯特·唐尼
             * id : 1016681
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1321812/
             * avatars : {"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp"}
             * name : 安东尼·罗素
             * id : 1321812
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp
                 * large : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp
                 * medium : https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
