package portsin;

import portsout.InfraestructuraException;

public interface RegistroParticipante {

	public void registrar(ParticipanteRecord participante) throws DomainException, InfraestructuraException;
}
