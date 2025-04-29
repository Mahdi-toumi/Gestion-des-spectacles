package com.enicarthage.Spectacles.User.Model;

public record LoginRequest(
        String email,
        String motp
) {}
