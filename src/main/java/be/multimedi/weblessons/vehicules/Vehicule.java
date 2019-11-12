package be.multimedi.weblessons.vehicules;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;

public class Vehicule implements Serializable {
    @NotBlank
    private String brand;
    @NotBlank
    private String type;
    @NotNull
    private FuelType fuel;
    @Min(1970)
    private int year;
    @Min(1)
    private int power;
    @NotNull
    private TransmissionType transmission;
    @NotNull
    @PastOrPresent
    private LocalDate entryIntoService;
    @Pattern(regexp = "^[0-9]-[A-Z]{3}-[0-9]{3}$")
    private String plate;
    @NotNull
    @Digits(fraction = 2, integer = 15)
    @DecimalMin("0.01")
    private float listPrice;
    private boolean towBar;
    private String[] options;

    public Vehicule() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FuelType getFuel() {
        return fuel;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public LocalDate getEntryIntoService() {
        return entryIntoService;
    }

    public void setEntryIntoService(LocalDate entryIntoService) {
        this.entryIntoService = entryIntoService;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public float getListPrice() {
        return listPrice;
    }

    public void setListPrice(float listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isTowBar() {
        return towBar;
    }

    public void setTowBar(boolean towBar) {
        this.towBar = towBar;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicule.class.getSimpleName() + "[", "]")
                .add("brand='" + brand + "'")
                .add("type='" + type + "'")
                .add("fuel=" + fuel)
                .add("year=" + year)
                .add("power=" + power)
                .add("transmission=" + transmission)
                .add("entryIntoService=" + entryIntoService)
                .add("plate='" + plate + "'")
                .add("listPrice=" + listPrice)
                .add("towBar=" + towBar)
                .add("options=" + Arrays.toString(options))
                .toString();
    }
}
