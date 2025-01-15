import java.time.LocalDate;

public class LogEntry {
    private int id;
    private String mitgliedsname;
    private String haus;
    private String ereignis;
    private LocalDate datum;

    public LogEntry(int id, String mitgliedsname, String haus, String ereignis, LocalDate datum) {
        this.id = id;
        this.mitgliedsname = mitgliedsname;
        this.haus = haus;
        this.ereignis = ereignis;
        this.datum = datum;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMitgliedsname() {
        return mitgliedsname;
    }

    public void setMitgliedsname(String mitgliedsname) {
        this.mitgliedsname = mitgliedsname;
    }

    public String getHaus() {
        return haus;
    }

    public void setHaus(String haus) {
        this.haus = haus;
    }

    public String getEreignis() {
        return ereignis;
    }

    public void setEreignis(String ereignis) {
        this.ereignis = ereignis;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", mitgliedsname='" + mitgliedsname + '\'' +
                ", haus='" + haus + '\'' +
                ", ereignis='" + ereignis + '\'' +
                ", datum=" + datum +
                '}';
    }
}
