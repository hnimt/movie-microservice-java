package fpt.trainining.movietheatre.service.mapper;

import fpt.trainining.movietheatre.dto.show_date.ShowDateRequest;
import fpt.trainining.movietheatre.dto.show_date.ShowDateResponse;
import fpt.trainining.movietheatre.entity.ShowDate;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShowDateMapper {
    private final ModelMapper mapper;

    public ShowDate map(ShowDateRequest request) {
        ShowDate showDate = mapper.map(request, ShowDate.class);
        showDate.setDayName(request.getShowDate().getDayOfWeek().toString());

        return showDate;
    }

    public ShowDateResponse map(ShowDate showDate) {
        return mapper.map(showDate, ShowDateResponse.class);
    }
}
