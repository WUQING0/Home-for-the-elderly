package bigdemo.bd.service.impl;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;

/*
    //人脸特征检测模块，注意：不要添加devtools的依赖，这会导致opencv无法正常运行
 */
public class FaceDetect {
    static String classifierFile = "D:\\openCV\\haarcascade_frontalface_default.xml";


    public static boolean detect(String inImg, String outImg) {
        boolean hasHumanFace = false;
        File f = new File(inImg); // 原图片不存在直接退出
        if (!f.exists()) {
            System.out.println("\n Image File Not Found!");
            return hasHumanFace;
        }
        // 获取原文件路径,让输出文件与原文件保存在同一路径
        String filePath = f.getAbsolutePath().substring(0, f.getAbsolutePath().indexOf(File.separator) + 1);
        // 加载OPENCV3.4本地库,必须先加载
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        CascadeClassifier faceDetector = new CascadeClassifier();
        /**
         * * 分类器，路径根据实际情况调整 * haarcascade_frontalface_default 默认 *
         * haarcascade_frontalface_alt 识别性能要好些
         */
        boolean loadSuccess = faceDetector.load(classifierFile);
        if (loadSuccess) {
            System.out.println("加载分类器成功:" + loadSuccess);
            // 读取图像
            Mat image = Imgcodecs.imread(inImg);
            // 用于保存检测到的人脸
            MatOfRect faceDetections = new MatOfRect();
            // 开始检测人脸
            faceDetector.detectMultiScale(image, faceDetections);
            // 检测到的人脸矩形坐标
            Rect[] faces = faceDetections.toArray();
            // 是否识别到人脸，返回值
            hasHumanFace = faces.length > 0 ? true : false;
            System.out.println(String.format("Detected %s faces", faces.length));
            int i = 0;
            for (Rect rect : faces) {
                // 循环所有检测到的人脸
                Point x = new Point(rect.x, rect.y);
                Point y = new Point(rect.x + rect.width, rect.y + rect.height);
                // 在image图片上画框，x，y可确定框的位置和大小，new Scalar(0,255,0)是框的颜色，自行调整
                Imgproc.rectangle(image, x, y, new Scalar(0, 255, 0)); // 保存检测的人脸小图片
                Rect r = new Rect(x, y);
                System.out.println(r.height + ":" + r.width);
                Mat areaM = new Mat(image, r); // 保存检测的人脸小图片到tmp+序号的jpg文件
                String tmpFilePath = filePath + "tmp" + (i++) + ".jpg";
                Imgcodecs.imwrite(tmpFilePath, areaM);
            }
            // 保存画了方框的图片
            String filename = outImg;
            Imgcodecs.imwrite(filename, image);
            // 销毁
            image.release();

        } else {
            System.out.println("加载分类器失败！请检查文件路径是否正确。");
        }
        return hasHumanFace;
    }

}