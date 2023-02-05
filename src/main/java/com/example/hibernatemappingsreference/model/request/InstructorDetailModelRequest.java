package com.example.hibernatemappingsreference.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class InstructorDetailModelRequest {
    @JsonProperty("youtube_channel")
    private String youtubeChannel;

    @JsonProperty("hobby")
    private String hobby;
}
