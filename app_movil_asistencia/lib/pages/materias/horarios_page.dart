import 'package:flutter/material.dart';
import 'package:app_movil_asistencia/config/helpers/getHorariosMateria.dart';
import 'package:app_movil_asistencia/infrastructure/models/horariosMateriaModel.dart';

class HorariosMateriaScreen extends StatefulWidget {
  final String codMateria;
  final int idGrupo;

  HorariosMateriaScreen({required this.codMateria, required this.idGrupo});

  @override
  _HorariosMateriaScreenState createState() => _HorariosMateriaScreenState();
}

class _HorariosMateriaScreenState extends State<HorariosMateriaScreen> {
  List<HorariosMateriaModel> _horarios = [];
  bool _isLoading = false;

  @override
  void initState() {
    super.initState();
    _loadHorarios();
  }

  Future<void> _loadHorarios() async {
    setState(() {
      _isLoading = true;
    });
    
    try {
      final horarios = await GetHorariosMateria().getHorariosMateria(widget.codMateria, widget.idGrupo);
      setState(() {
        _horarios = horarios;
        _isLoading = false;
      });
    } catch (e) {
      setState(() {
        _isLoading = false;
      });
      // Manejar el error, por ejemplo, mostrar un mensaje al usuario
      print('Error al cargar los horarios: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Horarios de Materia'),
      ),
      body: _isLoading
          ? Center(child: CircularProgressIndicator())
          : ListView.builder(
              itemCount: _horarios.length,
              itemBuilder: (context, index) {
                final horario = _horarios[index];
                return ListTile(
                  title: Text('Día: ${horario.dia}'),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Hora de inicio: ${horario.horaInicio}'),
                      Text('Hora de fin: ${horario.horaFin}'),
                    ],
                  ),
                );
              },
            ),
    );
  }
}
