package com.example.todoit.service;

import com.example.todoit.model.dto.AddEntryDto;
import com.example.todoit.model.Entry;
import com.example.todoit.repositories.EntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService {
    private final EntryRepository entryRepository;
    private final ModelMapper modelMapper;

    public EntryServiceImpl(EntryRepository entryRepository, ModelMapper modelMapper) {
        this.entryRepository = entryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createEntry(AddEntryDto entry) {
        this.entryRepository.save(map(entry));
    }

    private Entry map(AddEntryDto entryData) {
        Entry mappedEntry = modelMapper.map(entryData, Entry.class);
        mappedEntry.setTitle(mappedEntry.getTitle());
        mappedEntry.setContent(mappedEntry.getContent());
        return mappedEntry;
    }

}
