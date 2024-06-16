import 'package:app_movil_asistencia/config/helpers/getHorarios.dart';
import 'package:app_movil_asistencia/config/helpers/marcarAsistencia.dart';
import 'package:app_movil_asistencia/infrastructure/models/asistenciaModel.dart';
import 'package:flutter/material.dart';

class HorariosPage extends StatefulWidget {
  @override
  _HorariosPageState createState() => _HorariosPageState();
}

class _HorariosPageState extends State<HorariosPage> {
  String selectedModalidad = 'Presencial'; // Valor por defecto
  final MarcarAsistencia marcarAsistencia = MarcarAsistencia();

  Future<void> _mostrarDialogo(
      String codMateria, int idGrupo, String modalidad, int idHorario) async {
    return showDialog<void>(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('Información de Asistencia'),
          content: const SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                Text('¿Desea Registrar su Asistencia?'),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('Cancelar'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
            TextButton(
              child: const Text('Guardar Asistencia'),
              onPressed: () async {
                try {
                  await marcarAsistencia.marcarAsistencia(
                      codMateria, idGrupo, modalidad, idHorario);
                  // ignore: use_build_context_synchronously
                  ScaffoldMessenger.of(context).showSnackBar(
                    const SnackBar(
                      content: Text('Asistencia marcada exitosamente'),
                      duration: Duration(seconds: 2),
                    ),
                  );
                  setState(() {}); // Actualizar la UI
                } catch (e) {
                  // ignore: use_build_context_synchronously
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text('Error al marcar la asistencia: $e'),
                      duration: const Duration(seconds: 2),
                    ),
                  );
                }
                Navigator.of(context)
                    .pop(); // Cerrar el diálogo después de guardar
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Horarios de Materias'),
      ),
      body: FutureBuilder<List<HorariosModel>>(
        future: GetHorarios()
            .getHorarios(), // Cambiado para usar GetHorarios directamente
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: const CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('No hay horarios disponibles.'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                final horario = snapshot.data![index];

                return Padding(
                  padding: const EdgeInsets.symmetric(
                      horizontal: 8.0, vertical: 8.0),
                  child: Card(
                    elevation: 10.0,
                    child: ListTile(
                      contentPadding: const EdgeInsets.symmetric(
                          horizontal: 16.0, vertical: 10.0),
                      title: Text('${horario.nombre} - ${horario.codMateria}'),
                      subtitle: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text('Grupo: ${horario.idGrupo}'),
                          Text('Día: ${horario.dia}'),
                          Text(
                              'Hora: ${horario.horaInicio} - ${horario.horaFin}'),
                          TextButton.icon(
                            onPressed: () {
                              _mostrarDialogo(
                                  horario.codMateria,
                                  horario.idGrupo,
                                  selectedModalidad,
                                  horario.idHorario);
                            },
                            icon: const Icon(Icons.unarchive_outlined,
                                color: Colors.white),
                            label: const Text('Marcar Asistencia',
                                style: TextStyle(color: Colors.white)),
                            style: TextButton.styleFrom(
                              backgroundColor: Colors.black,
                              padding: const EdgeInsets.symmetric(
                                  horizontal: 16.0, vertical: 8.0),
                            ),
                          )
                        ],
                      ),
                      trailing: SizedBox(
                        width:
                            120.0, // Ancho fijo para evitar desbordamiento horizontal
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            DropdownButton<String>(
                              value: selectedModalidad,
                              onChanged: (String? newValue) {
                                setState(() {
                                  selectedModalidad = newValue!;
                                });
                              },
                              items: <String>[
                                'Presencial',
                                'Virtual'
                              ].map<DropdownMenuItem<String>>((String value) {
                                return DropdownMenuItem<String>(
                                  value: value,
                                  child: Text(value),
                                );
                              }).toList(),
                            ),
                          ],
                        ),
                      ),
                    ),
                  ),
                );
              },
            );
          }
        },
      ),
    );
  }
}
