@Service
public class DoctorService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public boolean isDoctorAvailable(Long doctorId, LocalDateTime appointmentTime) {
        // Check if the doctor exists
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        if (!doctorOpt.isPresent()) {
            return false; // Doctor not found
        }

        // Check if doctor has an appointment at this time
        List<Appointment> overlappingAppointments = appointmentRepository.findByDoctorIdAndAppointmentTime(doctorId, appointmentTime);

        // If there's already an appointment at that time, not available
        return overlappingAppointments.isEmpty();
    }
}
