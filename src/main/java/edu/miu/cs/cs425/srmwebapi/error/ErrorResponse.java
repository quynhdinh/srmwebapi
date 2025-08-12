package edu.miu.cs.cs425.srmwebapi.error;

public record ErrorResponse (
    String message,
    String errorCode
) {
}
