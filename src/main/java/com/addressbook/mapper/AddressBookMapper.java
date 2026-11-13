/*
 * Project Name: Address Book Application
 * Use Case: Section 2 - UC1
 * Description: Converts AddressBookDTO objects into Model objects and vice versa.
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

        return new AddressBookDTO(
                contactEntity.getFirstName(),
                contactEntity.getLastName(),
                contactEntity.getPhoneNumber()
        );
    }
}