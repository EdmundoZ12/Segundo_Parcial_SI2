import 'package:dio/dio.dart';
import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class MarcarAsistencia {
  final Dio dio = Dio();

  Future<void> marcarAsistencia(String codMateria, int idGrupo, String modalidad,int idHorario) async {
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

      // Construir el cuerpo de la solicitud
      final body = {
        'cod_materia': codMateria,
        'id_grupo': idGrupo,
        'modalidad': modalidad,
        'nro_registro': registro.toString(),
        'id_horario':idHorario
      };

      // Realizar la solicitud HTTP
      final response = await dio.post(
        'https://segundo-parcial-si2.onrender.com/api/asistencia/create',
        data: body,
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Verificar el estado de la respuesta
      if (response.statusCode == 200) {
        // La asistencia se marcó correctamente
        print('Asistencia marcada exitosamente');
      } else {
        // Manejar cualquier otro estado de respuesta
        throw Exception('Error al marcar la asistencia. Código de estado: ${response.statusCode}');
      }
    } catch (e) {
      print('Error al marcar la asistencia: $e');
      throw Exception('Error al marcar la asistencia');
    }
  }
}
