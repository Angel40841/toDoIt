package com.example.todoit.service;

import com.example.todoit.model.dto.AddEntryDto;

public interface EntryService {

    void createEntry(AddEntryDto entry);
}
