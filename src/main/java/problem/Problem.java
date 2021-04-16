package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Rectangle> rectangles;
    private Polygon resPolygon;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addPoint(double x, double y, double x2, double y2, double x3, double y3) {
        Rectangle rectangle = new Rectangle(new Vector2(x, y), new Vector2(x2, y2), new Vector2(x3, y3));
        rectangles.add(rectangle);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        double maxS = 0;
        for (int i = 0; i < rectangles.size(); i++) {
            for (int j = i + 1; j < rectangles.size(); j++) {
                ArrayList<Vector2> pointsV = new ArrayList<>();
                pointsV.add(rectangles.get(i).A);
                pointsV.add(rectangles.get(i).B);
                pointsV.add(rectangles.get(i).C);
                pointsV.add(rectangles.get(i).D);

                pointsV.add(rectangles.get(j).A);
                pointsV.add(rectangles.get(j).B);
                pointsV.add(rectangles.get(j).C);
                pointsV.add(rectangles.get(j).D);

                Line lineR1_1 = new Line(rectangles.get(i).A, rectangles.get(i).B);
                Line lineR1_2 = new Line(rectangles.get(i).B, rectangles.get(i).C);
                Line lineR1_3 = new Line(rectangles.get(i).C, rectangles.get(i).D);
                Line lineR1_4 = new Line(rectangles.get(i).D, rectangles.get(i).A);

                Line lineR2_1 = new Line(rectangles.get(j).A, rectangles.get(j).B);
                Line lineR2_2 = new Line(rectangles.get(j).B, rectangles.get(j).C);
                Line lineR2_3 = new Line(rectangles.get(j).C, rectangles.get(j).D);
                Line lineR2_4 = new Line(rectangles.get(j).D, rectangles.get(j).A);

                for (Line line1 : new Line[]{lineR1_1, lineR1_2, lineR1_3, lineR1_4})
                    for (Line line2 : new Line[]{lineR2_1, lineR2_2, lineR2_3, lineR2_4}) {
                        Vector2 pointI = line1.getIntersection(line2);
                        if (pointI != null)
                            pointsV.add(pointI);
                    }

                int finalJ = j;
                int finalI = i;
                pointsV.removeIf(p -> !rectangles.get(finalI).contains(p) || rectangles.get(finalJ).contains(p));
                Polygon polygon = new Polygon(pointsV);
                if (polygon.getS() > maxS) {
                    resPolygon = polygon;
                    maxS = polygon.getS();
                }

            }
        }


    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y, setVal);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Rectangle p = Rectangle.getRandomRectangle();
            rectangles.add(p);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        rectangles.clear();
        resPolygon = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        gl.glColor3d(1, 1, 1);
        for (Point point : points) {
            point.render(gl);
        }
        for (Rectangle rectangle : rectangles) {
            rectangle.render(gl);
        }
        gl.glColor3d(1, 0, 0);
        if (resPolygon != null)
            resPolygon.render(gl);

        // Figures.renderLine(gl,new Vector2(0,1) , new Vector2(-0,0),1);
        // Figures.renderTriangle(gl,new Vector2(0,0.3) , new Vector2(-0.9,0),new Vector2(0.4,0.5),false);
        // Figures.renderQuad(gl,new Vector2(1,1) , new Vector2(1,-1),new Vector2(-1,-1),new Vector2(-1,1),true);
        //Figures.renderCircle(gl,new Vector2(0,0),0.5,false);
//        Rectangle r = new Rectangle(new Vector2(0.6, 0.1), new Vector2(-0.1, -0.1), new Vector2(0.5, 0.5));
//        r.render(gl);
    }

}

