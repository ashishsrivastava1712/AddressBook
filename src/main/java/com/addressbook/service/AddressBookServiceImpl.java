/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Implements CRUD operations using an in-memory ArrayList.
 * Author: Ashish Srivastava
 * Date: 13/11/2026
 */

package com.addressbook.service;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.exception.ContactNotFoundException;
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

    // In-memory collection to store contacts
    private final List<AddressBook> contactStore = new ArrayList<>();

    // Generates a unique ID for every new contact
    private int nextContactId = 1;

    // Retrieve all contacts
    @Override
    public List<AddressBookDTO> getAllContacts() {

        logger.info("Fetching all contacts");

        // Convert every Model object into a DTO
        return contactStore.stream()
                .map(AddressBookMapper::toDTO)
                .toList();
    }

    // Retrieve a contact using its ID
    @Override
    public AddressBookDTO getContactById(int targetContactId) {

        logger.info("Fetching contact with ID: {}", targetContactId);

        AddressBook contactToDelete = findContactById(targetContactId);

        return AddressBookMapper.toDTO(contact);
    }

    // Create and store a new contact
    @Override
    public AddressBookDTO createContact(AddressBookDTO contactDTO) {

        logger.info("Creating a new contact");

        // Convert DTO into Model with a generated ID
        AddressBook contact =
                AddressBookMapper.toModel(dto, nextContactId++);

        // Store contact in the in-memory List
        contactStore.add(newContact);

        logger.info("Contact created with ID: {}", contact.getId());

        return AddressBookMapper.toDTO(contact);
    }

    // Update an existing contact
    @Override
    public AddressBookDTO updateContact(int targetContactId, AddressBookDTO contactDTO) {

        logger.info("Updating contact with ID: {}", targetContactId);

        // Find the existing contact
        AddressBook existingContact = findContactById(targetContactId);

        // Update its fields
        existingContact.setFirstName(contactDTO.getFirstName());
        existingContact.setLastName(contactDTO.getLastName());
        existingContact.setPhoneNumber(contactDTO.getPhoneNumber());

        return AddressBookMapper.toDTO(existingContact);
    }

    // Delete a contact using its ID
    @Override
    public String deleteContact(int targetContactId) {

        logger.info("Deleting contact with ID: {}", targetContactId);

        // Find contact before deleting it
        AddressBook contactToDelete = findContactById(targetContactId);

        contactStore.remove(contactToDelete);

        return "Contact deleted successfully with ID: " + targetContactId;
    }

    // Find a contact or throw an exception if it does not exist
    private AddressBook findContactById(int targetId) {

        return contactStore.stream()
                .filter(contact -> contact.getId() == targetId)
                .findFirst()
                .orElseThrow(() ->
                        new ContactNotFoundException(
                                "Contact not found with ID: " + targetId
                        )
                );
    }
}