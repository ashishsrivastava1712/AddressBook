/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC3
 * Description: Converts AddressBook Model objects into DTOs and DTOs into Models.
 * Author: Ashish Srivastava
 * Date: 13/11/2026
 */

package com.addressbook.mapper;

import com.addressbook.dto.AddressBookDTO;
import com.addressbook.model.AddressBook;

public class AddressBookMapper {

    // Convert DTO into Model
    public static AddressBook toModel(AddressBookDTO contactDTO, int generatedId) {

        return new AddressBook(
                id,
                contactDTO.getFirstName(),
                contactDTO.getLastName(),
                contactDTO.getPhoneNumber()
        );
    }

    // Convert Model into DTO
    public static AddressBookDTO toDTO(AddressBook contactEntity) {

        AddressBookDTO dto = new AddressBookDTO(
                contactEntity.getFirstName(),
                contactEntity.getLastName(),
                contactEntity.getPhoneNumber()
        );

        // Include contact ID in API response
        dto.setId(contactEntity.getId());

        return dto;
    }
}