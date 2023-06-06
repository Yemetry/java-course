public class Cinema {
    private String title;
    private String genre;
    private double duration;

    public Cinema(String title, String genre, double duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getDuration() {
        return duration;
    }
}

import java.util.List;

public class Viewer {
    private String username;
    private int age;
    private List<Cinema> viewedMovies;

    public Viewer(String username, int age, List<Cinema> viewedMovies) {
        this.username = username;
        this.age = age;
        this.viewedMovies = viewedMovies;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfViewedMovies() {
        return viewedMovies.size();
    }

    public List<Cinema> getViewedMovies() {
        return viewedMovies;
    }
}

import java.util.List;

public class ViewerStatistics {
    public double averageAge(List<Viewer> viewers) {
        int sum = 0;
        for (Viewer viewer : viewers) {
            sum += viewer.getAge();
        }
        return (double) sum / viewers.size();
    }

    public double averageNumberOfViewedMovies(List<Viewer> viewers) {
        int sum = 0;
        for (Viewer viewer : viewers) {
            sum += viewer.getNumberOfViewedMovies();
        }
        return (double) sum / viewers.size();
    }
}

import java.util.ArrayList;
import java.util.List;

public class CinemaApplicationRun {

    public static void main(String[] args) {
        // создаем список пользователей
        List<Viewer> viewers = new ArrayList<>();
        viewers.add(new Viewer("user1", 25, createMoviesList()));
        viewers.add(new Viewer("user2", 30, createMoviesList()));
        viewers.add(new Viewer("user3", 20, createMoviesList()));
        viewers.add(new Viewer("user4", 27, createMoviesList()));
        viewers.add(new Viewer("user5", 23, createMoviesList()));

        // считаем средний возраст пользователей
        ViewerStatistics viewerStatistics = new ViewerStatistics();
        double averageAge = viewerStatistics.averageAge(viewers);

        // выводим результат на экран
        System.out.printf("Средний возраст пользователей: %.1f\n", averageAge);

        // выводим список просмотренных фильмов для каждого пользователя
        for (Viewer viewer : viewers) {
            System.out.println(viewer.getName() + " просмотрел следующие фильмы:");
            for (Cinema movie : viewer.getMoviesList()) {
                System.out.println("- " + movie.getTitle() + ", жанр: " + movie.getGenre() + ", продолжительность: " + movie.getDuration() + " часов");
            }
            System.out.println();
        }
    }

    // создаем список фильмов для каждого пользователя
    private static List<Cinema> createMoviesList() {
        List<Cinema> moviesList = new ArrayList<>();
        moviesList.add(new Cinema("Фильм 1", "драма", 2));
        moviesList.add(new Cinema("Фильм 2", "комедия", 1.5));
        moviesList.add(new Cinema("Фильм 3", "фантастика", 2.5));
        return moviesList;
    }

}