package repository;

public class OvertimeHours implements HoursRepository{
    @Override
    public int getHours(){
        return 15;
    }
}
