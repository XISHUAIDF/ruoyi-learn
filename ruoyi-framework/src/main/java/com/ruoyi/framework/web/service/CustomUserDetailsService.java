package com.ruoyi.framework.web.service;

import com.ruoyi.competition.domain.Participants;
import com.ruoyi.competition.domain.ParticipantsLoginUser;
import com.ruoyi.competition.mapper.ParticipantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ParticipantsMapper participantsMapper;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Participants participants = participantsMapper.selectParticipantsByUsername(username);
        if (participants == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new ParticipantsLoginUser(participants.getId(),participants.getPassword());
    }
}
