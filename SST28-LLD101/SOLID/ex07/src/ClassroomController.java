public class ClassroomController {
    private final Switchable projectorPower;
    private final InputConnectable projectorInput;
    private final Switchable lightsPower;
    private final Dimmable lightsBrightness;
    private final Switchable acPower;
    private final TemperatureControllable acTemp;
    private final AttendanceSource scanner;

    public ClassroomController(
            Switchable projectorPower,
            InputConnectable projectorInput,
            Switchable lightsPower,
            Dimmable lightsBrightness,
            Switchable acPower,
            TemperatureControllable acTemp,
            AttendanceSource scanner) {
        this.projectorPower = projectorPower;
        this.projectorInput = projectorInput;
        this.lightsPower = lightsPower;
        this.lightsBrightness = lightsBrightness;
        this.acPower = acPower;
        this.acTemp = acTemp;
        this.scanner = scanner;
    }

    public void startClass() {
        projectorPower.powerOn();
        projectorInput.connectInput("HDMI-1");

        lightsBrightness.setBrightness(60);

        acTemp.setTemperatureC(24);

        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        projectorPower.powerOff();
        lightsPower.powerOff();
        acPower.powerOff();
    }
}
