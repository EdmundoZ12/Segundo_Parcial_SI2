import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:app_movil_asistencia/config/helpers/get_materias.dart';
import 'package:app_movil_asistencia/infrastructure/models/materiModel.dart';
import 'package:app_movil_asistencia/pages/materias/horarios_page.dart'; // Asegúrate de importar HorariosMateriaScreen

class MateriasPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Lista de Materias'),
      ),
      body: FutureBuilder<List<MateriasModel>>(
        future: Provider.of<GetMaterias>(context, listen: false).getMaterias(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return Center(child: Text('No hay materias disponibles.'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                final materia = snapshot.data![index];
                return Card(
                  margin: EdgeInsets.all(8.0),
                  elevation: 4.0,
                  child: ListTile(
                    title: Text(materia.nombreMateria),
                    subtitle: Text('Código: ${materia.codMateria}'),
                    trailing: TextButton.icon(
                      onPressed: () {
                        Navigator.of(context).push(
                          MaterialPageRoute(
                            builder: (context) => HorariosMateriaScreen(
                              codMateria: materia.codMateria,
                              idGrupo: materia.idGrupo,
                            ),
                          ),
                        );
                      },
                      icon: Icon(Icons.access_time, color: Colors.white),
                      label: Text('Ver horario', style: TextStyle(color: Colors.white)),
                      style: TextButton.styleFrom(
                        backgroundColor: Colors.black,
                        padding: EdgeInsets.symmetric(horizontal: 16.0, vertical: 8.0),
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
