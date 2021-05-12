package org.example.model;

public class Image {
    /*image_id int not null primary key auto_increment,
        image_name varchar(50),
        size bigint,
        upload_time varchar(50),
        md5 varchar(128),
        content_type varchar(50) comment '图片类型',
        path varchar(1024) comment '图片所在路径')*/
    private int imageId;
    private String image_name;
    private int size;
    private String upload_time;
    private String md5;
    private String content_type;
    private String path;

    @Override
    public String toString() {
        return "Image{" +
                "imageId=" + imageId +
                ", image_name='" + image_name + '\'' +
                ", size=" + size +
                ", upload_time='" + upload_time + '\'' +
                ", md5='" + md5 + '\'' +
                ", content_type='" + content_type + '\'' +
                ", path='" + path + '\'' +
                '}';
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
