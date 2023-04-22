package model;

import portsin.DomainException;
import portsin.ParticipanteRecord;
import portsin.RegistroParticipante;
import portsout.InfraestructuraException;
import portsout.Registro;

public class Servicio implements RegistroParticipante {
	private Registro registro;

	public Servicio(Registro registro) {
		this.registro = registro;
	}

	public void registrar(ParticipanteRecord participante) throws DomainException, InfraestructuraException {
		Participante nuevoParticipante = new Participante(participante.nombre(), participante.telefono(),
				participante.region());

		registro.registrar(nuevoParticipante.getNombre(), nuevoParticipante.getTelefono(),nuevoParticipante.getRegion());

	}

}