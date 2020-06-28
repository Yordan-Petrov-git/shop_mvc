package com.shop.advance.academy.yordan.petrov.git.shop.domain.models;

import com.shop.advance.academy.yordan.petrov.git.shop.data.entities.Currency;
import com.shop.advance.academy.yordan.petrov.git.shop.data.entities.enums.CardProviders;
import com.shop.advance.academy.yordan.petrov.git.shop.data.entities.enums.CardType;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CardServiceModel {

    private Long id;
    private CardType cardType = CardType.NONE;
    private CardProviders cardProviders = CardProviders.NONE;
    private LocalDate expirationDate;
    private LocalDateTime dateIssued;
    private String cvvCode;
    private String pinCode;
    private String number;
    private BigDecimal balance;
    private CurrencyServiceModel currency;
    private boolean isActive = true;


    public CardServiceModel() {
    }


    public CardServiceModel(Long id, CardType cardType, CardProviders cardProviders,
                            LocalDate expirationDate, LocalDateTime dateIssued, String cvvCode,
                            String pinCode, String number, BigDecimal balance,
                            CurrencyServiceModel currency, boolean isActive) {
        this.id = id;
        this.cardType = cardType;
        this.cardProviders = cardProviders;
        this.expirationDate = expirationDate;
        this.dateIssued = dateIssued;
        this.cvvCode = cvvCode;
        this.pinCode = pinCode;
        this.number = number;
        this.balance = balance;
        this.currency = currency;
        this.isActive = isActive;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return this.cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardProviders getCardProviders() {
        return this.cardProviders;
    }

    public void setCardProviders(CardProviders cardProviders) {
        this.cardProviders = cardProviders;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getDateIssued() {
        return this.dateIssued;
    }

    public void setDateIssued(LocalDateTime dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getCvvCode() {
        return this.cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CurrencyServiceModel getCurrency() {
        return this.currency;
    }

    public void setCurrency(CurrencyServiceModel currency) {
        this.currency = currency;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardServiceModel)) return false;
        CardServiceModel that = (CardServiceModel) o;
        return isActive == that.isActive &&
                Objects.equals(id, that.id) &&
                cardType == that.cardType &&
                cardProviders == that.cardProviders &&
                Objects.equals(expirationDate, that.expirationDate) &&
                Objects.equals(cvvCode, that.cvvCode) &&
                Objects.equals(pinCode, that.pinCode) &&
                Objects.equals(number, that.number) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType, cardProviders, expirationDate, cvvCode, pinCode, number, balance, isActive);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CardServiceModel{");
        sb.append("id=").append(id);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardProviders=").append(cardProviders);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", cvvCode='").append(cvvCode).append('\'');
        sb.append(", pinCode='").append(pinCode).append('\'');
        sb.append(", number='").append(number).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", isActive=").append(isActive);
        sb.append('}');
        return sb.toString();
    }
}
