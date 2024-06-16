import 'package:app_movil_asistencia/infrastructure/models/asistenciaModel.dart';
import 'package:dio/dio.dart';
import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class GetHorarios {
  final Dio dio = Dio();

  Future<List<HorariosModel>> getHorarios() async {
    try {
      // Obtener el token de SharedPreferences
      final prefs = await SharedPreferences.getInstance();
      final token = prefs.getString('token');
      if (token == null) {
        throw Exception('Token no encontrado');
      }

      // Decodificar el token JWT para obtener el número de registro
      Map<String, dynamic> payload = Jwt.parseJwt(token);
      final registro = payload['nro_registro'];
      if (registro == null || !(registro is String)) {
        throw Exception('Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP para obtener los horarios
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/horarios/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> horariosJson = response.data;
        List<HorariosModel> horarios = horariosJson
            .map((json) => HorariosModel.fromJson(json))
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
