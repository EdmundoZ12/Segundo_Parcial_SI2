import 'package:app_movil_asistencia/config/helpers/getControlAsistencias.dart';
import 'package:app_movil_asistencia/config/helpers/getHorarios.dart';
import 'package:app_movil_asistencia/config/helpers/getHorariosMateria.dart';
import 'package:app_movil_asistencia/config/helpers/get_materias.dart';
import 'package:app_movil_asistencia/config/router/app_router.dart';
import 'package:app_movil_asistencia/config/theme/app_theme.dart';
import 'package:app_movil_asistencia/infrastructure/models/user_Model.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // Definir rutas
    return MultiProvider(
        providers: [
          ChangeNotifierProvider(create: (_) => UserModel()),
          Provider(create: (_)=>GetMaterias()),
          Provider(create: (_)=>GetHorarios()),
          Provider(create: (_)=>GetHorariosMateria()),
          Provider(create: (_)=>GetControl())
        ],
        child: MaterialApp.router(
          title: 'Ssitema',
          debugShowCheckedModeBanner: false,
          theme: AppTheme(selectedColor: 0).getTheme(),
          routerConfig: appRouter,
        ));
  }
}
