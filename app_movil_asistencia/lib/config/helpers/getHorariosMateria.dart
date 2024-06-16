import 'package:app_movil_asistencia/infrastructure/models/horariosMateriaModel.dart';
import 'package:dio/dio.dart';
import 'package:shared_preferences/shared_preferences.dart';

class GetHorariosMateria {
  final Dio dio = Dio();

  Future<List<HorariosMateriaModel>> getHorariosMateria(String codMateria,int idGrupo) async {
    try {
      // Obtener el token de SharedPreferences
      final prefs = await SharedPreferences.getInstance();
      final token = prefs.getString('token');
      if (token == null) {
        throw Exception('Token no encontrado');
      }


      // Realizar la solicitud HTTP para obtener los horarios
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/horario/materia/$codMateria/grupo/$idGrupo',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> horariosJson = response.data;
        List<HorariosMateriaModel> horarios = horariosJson
            .map((json) => HorariosMateriaModel.fromJson(json))
            .toList();
        return horarios;
      } else {
        throw Exception('Failed to load horarios');
      }
    } catch (e) {
      print('Error fetching horarios: $e');
      throw Exception('Failed to load horarios');
    }
  }
}
