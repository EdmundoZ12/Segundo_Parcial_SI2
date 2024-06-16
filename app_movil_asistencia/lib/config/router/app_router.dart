import 'package:app_movil_asistencia/pages/asistencia/asistencia_horarios.dart';
import 'package:app_movil_asistencia/pages/controlAsistencias/asistenciasPage.dart';
import 'package:app_movil_asistencia/pages/controlAsistencias/faltasPage.dart';
import 'package:app_movil_asistencia/pages/controlAsistencias/licenciasPage.dart';
import 'package:app_movil_asistencia/pages/controlAsistencias/retrasosPage.dart';
import 'package:app_movil_asistencia/pages/home/home_screen1.dart';
import 'package:app_movil_asistencia/pages/login/login_page.dart';
import 'package:app_movil_asistencia/pages/materias/materia_page.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:shared_preferences/shared_preferences.dart';
import '../../pages/screens.dart';

Future<bool> _checkLoginStatus() async {
  SharedPreferences prefs = await SharedPreferences.getInstance();
  String? token = prefs.getString('token');
  return token != null;
}

// GoRouter configuration
final appRouter = GoRouter(
  initialLocation: '/',
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => FutureBuilder<bool>(
        future: _checkLoginStatus(),
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          } else if (snapshot.hasData && snapshot.data == true) {
            return const HomePage();
          } else {
            return const LoginScreen();
          }
        },
      ),
    ),
    GoRoute(
      path: '/home',
      name: HomePage.name,
      builder: (context, state) => const HomePage(),
    ),
    GoRoute(
      path: '/login',
      builder: (context, state) => const LoginScreen(),
    ),
    GoRoute(
      path: '/materias',
      builder: (context, state) => MateriasPage(),
    ),
    GoRoute(
      path: '/horarios',
      builder: (context, state) => HorariosPage(),
    ),
    GoRoute(
      path: '/retrasos',
      builder: (context, state) => const RetrasosPage(),
    ),
    GoRoute(
      path: '/asistencias',
      builder: (context, state) => const AsistenciasPage(),
    ),
    GoRoute(
      path: '/faltas',
      builder: (context, state) => const FaltasPage(),
    ),
    GoRoute(
      path: '/licencias',
      builder: (context, state) => const LicenciasPage(),
    ),
  ],
);
