package com.project.bookingmovieticket.Service.Implementation;

import com.project.bookingmovieticket.Convertor.MovieConvertor;
import com.project.bookingmovieticket.Convertor.ShowConvertor;
import com.project.bookingmovieticket.Convertor.TheatreConvertor;
import com.project.bookingmovieticket.DTO.EntryDTO.ShowEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.MovieResponseDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.ShowResponseDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TheatreResponseDto;
import com.project.bookingmovieticket.Models.*;
import com.project.bookingmovieticket.Repository.MovieRepository;
import com.project.bookingmovieticket.Repository.ShowRepository;
import com.project.bookingmovieticket.Repository.ShowSeatsRepository;
import com.project.bookingmovieticket.Repository.TheatreRepository;
import com.project.bookingmovieticket.Service.ShowService;
import com.project.bookingmovieticket.Models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImplement implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;


    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity show= ShowConvertor.convertDtoToEntity(showEntryDto);

        MovieEntity movie = movieRepository.findById(showEntryDto.getMovieId()).get();
        TheatreEntity theatre=theatreRepository.findById(showEntryDto.getTheatreId()).get();

        show.setMovie(movie);
        show.setTheatre(theatre);
        show=showRepository.save(show);
        generateShowSeats(theatre.getThreatreSeats(),show);

        ShowResponseDto showResponseDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showResponseDto;
    }
    public void generateShowSeats(List<TheatreSeatsEntity> theatreSeats, ShowEntity show){
        List<ShowSeatsEntity> showSeats= new ArrayList<>();

        log.info("The list of theatre entity seats");
        for(TheatreSeatsEntity temp:theatreSeats){
            ShowSeatsEntity showSeatsEntity=ShowSeatsEntity.builder().seatNo(temp.getSeatNumber())
                            .seatType(temp.getSeatType()).rate(temp.getRate()).build();
            showSeats.add(showSeatsEntity);
        }
        for(ShowSeatsEntity showSeatsEntity:showSeats){
            showSeatsEntity.setShow(show);
        }
        showSeatsRepository.saveAll(showSeats);
        show.setSeats(showSeats);
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity show=showRepository.findById(id).get();
        MovieEntity movie=movieRepository.findById(show.getMovie().getId()).get();
        TheatreEntity theatre=theatreRepository.findById(show.getTheatre().getId()).get();
        MovieResponseDto movieResponseDto= MovieConvertor.convertEntityToDto(movie);
        TheatreResponseDto theatreResponseDto= TheatreConvertor.convertEntitytoDto(theatre);
        //showEntry
        ShowEntryDto showEntryDto=ShowEntryDto.builder().showDate(show.getShowDate()).movieId(show.getMovie().getId()).theatreId(show.getTheatre().getId()).build();
        ShowResponseDto showDto=ShowConvertor.convertEntityToDto(show,showEntryDto);
        return showDto;
    }
}
