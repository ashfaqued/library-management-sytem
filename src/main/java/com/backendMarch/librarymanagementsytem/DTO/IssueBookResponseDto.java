package com.backendMarch.librarymanagementsytem.DTO;

import com.backendMarch.librarymanagementsytem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transanctionId;

    private String bookName;

  //  private String priceName;
    private TransactionStatus transactionStatus;

}
