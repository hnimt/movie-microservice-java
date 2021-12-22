package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.movie.MovieRequest;
import fpt.trainining.movietheatre.dto.movie.MovieResponse;
import fpt.trainining.movietheatre.entity.Movie;
import fpt.trainining.movietheatre.entity.Schedule;
import fpt.trainining.movietheatre.entity.ShowDate;
import fpt.trainining.movietheatre.entity.Type;
import fpt.trainining.movietheatre.exception.InvalidRequestException;
import fpt.trainining.movietheatre.repository.ScheduleRepository;
import fpt.trainining.movietheatre.repository.ShowDateRepository;
import fpt.trainining.movietheatre.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
@AllArgsConstructor
public class MovieMapper {
    private final ModelMapper mapper;
    private final ShowDateRepository showDateRepository;
    private final ScheduleRepository scheduleRepository;
    private final TypeRepository typeRepository;

    public Movie map(MovieRequest request) {
        Movie movie = mapper.map(request, Movie.class);

        Set<LocalDate> showDates = request.getShowDates();
        Set<LocalTime> schedules = request.getSchedules();

        showDates.stream().forEach(
                showDate -> {
                    if (showDate.isBefore(request.getFromDate()) || showDate.isAfter(request.getToDate())) {
                        throw new InvalidRequestException("There is a show date invalid");
                    }
                }
        );

        Collection<ShowDate> showDateCollection = new ArrayList<>();
        showDates.stream().forEach(
                showDate -> {
                    Optional<ShowDate> optionalShowDate = showDateRepository.findShowDateByShowDate(showDate);

                    ShowDate showDateEntity = new ShowDate(showDate, showDate.getDayOfWeek().toString());
                    if (!optionalShowDate.isPresent()) {
                        showDateRepository.save(showDateEntity);
                        showDateCollection.add(showDateEntity);
                    }
                    else {
                        showDateCollection.add(optionalShowDate.get());
                    }

                }
        );
        movie.setShowDates(showDateCollection);

        Collection<Schedule> scheduleCollection = new ArrayList<>();
        schedules.stream().forEach(
                schedule -> {
                    Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleByScheduleTime(schedule);

                    Schedule scheduleEntity = new Schedule();
                    scheduleEntity.setScheduleTime(schedule);
                    if (!optionalSchedule.isPresent()) {
                        scheduleRepository.save(scheduleEntity);
                        scheduleCollection.add(scheduleEntity);
                    }
                    else {
                        scheduleCollection.add(optionalSchedule.get());
                    }

                }
        );
        movie.setSchedules(scheduleCollection);

//        List<ShowDate> showDates = new ArrayList<>();
//        request.getShowDateId().stream().forEach(
//                showDateId -> {
//                    showDates.add(showDateRepository.findById(showDateId).get());
//                }
//        );
//        movie.setShowDates(showDates);
//
//        List<Schedule> schedules = new ArrayList<>();
//        request.getScheduleId().stream().forEach(
//                scheduleId -> {
//                    schedules.add(scheduleRepository.findById(scheduleId).get());
//                }
//        );
//        movie.setSchedules(schedules);

        List<Type> types = new ArrayList<>();
        request.getTypeId().stream().forEach(
                typeId -> {
                    types.add(typeRepository.findById(typeId).get());
                }
        );
        movie.setTypes(types);

        return movie;
    }

    public MovieResponse map(Movie movie) {

        MovieResponse response = mapper.map(movie, MovieResponse.class);

        return response;
    }

    public void map(MovieRequest request, Movie movie) {
        mapper.map(request, movie);
    }
}
