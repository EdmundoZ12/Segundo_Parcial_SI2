import 'package:flutter/material.dart';

class MenuItem {
  final String title;
  final String subTitle;
  final String link;
  final IconData icon;

  const MenuItem(
      {required this.title,
      required this.subTitle,
      required this.link,
      required this.icon});
}

const appMenuItems = <MenuItem>[
  // MenuItem(
  //     title: 'Botones',
  //     subTitle: 'Varios Botones',
  //     link: '/buttons',
  //     icon: Icons.smart_button_outlined),
  // MenuItem(
  //     title: 'Roles',
  //     subTitle: 'Varios Roles',
  //     link: '/roles',
  //     icon: Icons.smart_button_outlined),
  MenuItem(
      title: 'Materias',
      subTitle: 'Varias Materias',
      link: '/materias',
      icon: Icons.book_outlined),
  MenuItem(
      title: 'Horarios',
      subTitle: 'Horarios Cercas',
      link: '/horarios',
      icon: Icons.calendar_month_rounded),
  MenuItem(
      title: 'Asistencias',
      subTitle: 'Asistencias puntuales.',
      link: '/asistencias',
      icon: Icons.timer_sharp),
  MenuItem(
      title: 'Retrasos',
      subTitle: 'Asistencias con retrasos de 15 min.',
      link: '/retrasos',
      icon: Icons.timer_sharp),
  MenuItem(
      title: 'Faltas',
      subTitle: 'Ausencia a clases.',
      link: '/faltas',
      icon: Icons.timer_sharp),
  MenuItem(
      title: 'Licencias',
      subTitle: 'Falta justificada.',
      link: '/licencias',
      icon: Icons.timer_sharp),
];
