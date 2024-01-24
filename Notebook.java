import java.util.Objects;

public class Notebook {
    private int hardDiskCapacity; //Объем жесткого диска
    private int amountOfRAM; //Объем оперативной памяти
    private String manufacturer; // Производитель
    private String operatingSystem; //Операционная система
    private double screenDiagonal; // Диагональ экрана

    public Notebook(int hardDiskCapacity, int amountOfRAM, String manufacturer, String operatingSystem, double screenDiagonal) {
        this.hardDiskCapacity = hardDiskCapacity;
        this.amountOfRAM = amountOfRAM;
        this.manufacturer = manufacturer;
        this.operatingSystem = operatingSystem;
        this.screenDiagonal = screenDiagonal;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public int getAmountOfRAM() {
        return amountOfRAM;
    }

    public void setAmountOfRAM(int amountOfRAM) {
        this.amountOfRAM = amountOfRAM;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "hardDiskCapacity=" + hardDiskCapacity +
                ", amountOfRAM=" + amountOfRAM +
                ", manufacturer='" + manufacturer + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", screenDiagonal=" + screenDiagonal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return hardDiskCapacity == notebook.hardDiskCapacity && amountOfRAM == notebook.amountOfRAM && Double.compare(screenDiagonal, notebook.screenDiagonal) == 0 && Objects.equals(manufacturer, notebook.manufacturer) && Objects.equals(operatingSystem, notebook.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hardDiskCapacity, amountOfRAM, manufacturer, operatingSystem, screenDiagonal);
    }
}
