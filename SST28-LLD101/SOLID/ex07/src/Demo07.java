public class Demo07 {
    public static void main(String[] args) {
        System.out.println("=== Smart Classroom ===");

        Projector projector = new Projector();
        LightsPanel lights = new LightsPanel();
        AirConditioner ac = new AirConditioner();
        AttendanceScanner scanner = new AttendanceScanner();

        ClassroomController controller = new ClassroomController(
                projector, projector,
                lights, lights,
                ac, ac,
                scanner
        );

        controller.startClass();
        controller.endClass();
    }
}
