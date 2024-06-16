import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:app_movil_asistencia/config/helpers/getControlAsistencias.dart';
import 'package:app_movil_asistencia/infrastructure/models/asistenciasPresentesModel.dart';

class AsistenciasPage extends StatelessWidget {
  const AsistenciasPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Asistencias'),
      ),
      body: FutureBuilder<List<AsistenciasModel>>(
        future:
            Provider.of<GetControl>(context, listen: false).getAsistencias(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return const Center(child: Text('No hay asistencias disponibles.'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                final asistencia = snapshot.data![index];
                return Card(
                  margin: const EdgeInsets.all(8.0),
                  elevation: 4.0,
                  child: ListTile(
                    title: Text(asistencia.nombreMateria),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Fecha: ${asistencia.fecha.toString()}'),
                        Text('Hora: ${asistencia.hora}'),
                        Text('Motivo: ${asistencia.motivo}'),
                        Text('Modalidad: ${asistencia.modalidad}'),
                      ],
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
