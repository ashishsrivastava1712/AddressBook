/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC2
 * Description: Implements AddressBook service operations and handles business logic.
 * Author: Ashish Srivastava
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.mapper.AddressBookMapper;
import com.addressbook.model.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private static final Logger logger =
            LoggerFactory.getLogger(AddressBookServiceImpl.class);

    // Temporary ID counter; actual storage comes in UC3
    private int nextContactId = 1;

    // Return an empty list because storage is not implemented yet
    @Override
    public List<AddressBookDTO> getAllContacts() {

        logger.info("Service: Fetching all contacts");

        return new ArrayList<>();
    }

    // Return a sample contact to demonstrate service delegation
    @Override
    public AddressBookDTO getContactById(int targetContactId) {

        logger.info("Service: Fetching contact with ID {}", id);

        AddressBook model = new AddressBook(
                id,
                "Sample",
                "Contact",
                "9876543210"
        );

        return AddressBookMapper.toDTO(model);
    }

    // Convert DTO to Model and return the response DTO
    @Override
    public AddressBookDTO createContact(AddressBookDTO contactDTO) {

        logger.info("Service: Creating a contact");

        AddressBook model =
                AddressBookMapper.toModel(dto, nextContactId++);

        return AddressBookMapper.toDTO(model);
    }

    // Convert the updated DTO into a Model and return it as DTO
    @Override
    public AddressBookDTO updateContact(int targetContactId, AddressBookDTO contactDTO) {

        logger.info("Service: Updating contact with ID {}", id);

        AddressBook model =
                AddressBookMapper.toModel(dto, id);

        return AddressBookMapper.toDTO(model);
    }

    // Demonstrate delete operation
    @Override
    public String deleteContact(int targetContactId) {

        logger.info("Service: Deleting contact with ID {}", id);

        return "DELETE request successful for ID: " + id;
    }
}