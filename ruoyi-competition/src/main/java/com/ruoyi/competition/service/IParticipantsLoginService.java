package com.ruoyi.competition.service;

public interface IParticipantsLoginService {
    public String login(String username, String password, String code, String uuid);
    public void validateCaptcha(String username, String code, String uuid);
    public void loginPreCheck(String username, String password);
}
