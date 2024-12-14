package vista.laminas;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import controlador.*;
import vista.ventanas.VentanaTerminos;
	
public class LaminaRegistro extends JPanel {

		public LaminaRegistro () {
			
			//Creación de los items
			
			JLabel regNombre=new JLabel("Introduce tu nombre:");
			JLabel regApe1=new JLabel("Introduce tu primer apellido:");
			JLabel regApe2=new JLabel("Introduce tu segundo apellido:");
			JLabel regNick=new JLabel("Introduce tu alias:");
			JLabel email1=new JLabel ("Introduce tu email:");
			JLabel email2=new JLabel ("Repite tu email:");
			JLabel pass1=new JLabel("Introduce tu contraseña:");
			JLabel pass2=new JLabel ("Repite tu contraseña:");
			JLabel queSoy=new JLabel ("¿Eres autor o lector?");
			JLabel blanco=new JLabel("");
			JLabel blanco2=new JLabel("");
			acepto=new JCheckBox("Acepto las condiciones.");
			ButtonGroup autor_lector=new ButtonGroup();
			autor=new JRadioButton("Autor", false);
			JRadioButton lector=new JRadioButton("Lector", true);
			autor_lector.add(autor);
			autor_lector.add(lector);
			
			
			
			// Definición de los campos a rellenar
			
			nick=new JTextField(16);
			nom_usuario=new JTextField(16);
			ape1=new JTextField(16);
			ape2=new JTextField(16);
			correo=new JTextField(16);
			correo2=new JTextField(16);
			password=new JPasswordField(16);
			password2=new JPasswordField(16);
			
			/*
			correo.setBorder(BorderFactory.createLineBorder(Color.RED));
			correo2.setBorder(BorderFactory.createLineBorder(Color.RED));
			password.setBorder(BorderFactory.createLineBorder(Color.RED));
			password2.setBorder(BorderFactory.createLineBorder(Color.RED));
			*/
			
			JButton botonAcceso=new JButton ("Leer términos y condiciones");
			botonRegistro=new JButton ("Registrarme");
			botonRegistro.setEnabled(false);
		
			
			regNombre.setHorizontalAlignment(JTextField.CENTER);
			regApe1.setHorizontalAlignment(JTextField.CENTER);
			regApe2.setHorizontalAlignment(JTextField.CENTER);
			regNick.setHorizontalAlignment(JTextField.CENTER);
			email1.setHorizontalAlignment(JTextField.CENTER);
			email2.setHorizontalAlignment(JTextField.CENTER);
			pass1.setHorizontalAlignment(JTextField.CENTER);
			pass2.setHorizontalAlignment(JTextField.CENTER);
			acepto.setHorizontalAlignment(JTextField.CENTER);
			queSoy.setHorizontalAlignment(JTextField.CENTER);
			
			// Evento para comprobar que los campos son iguales entre sí.
			
			KeyListener comprobador=new KeyAdapter() {
				
				
				public void keyReleased (KeyEvent e) {					
					
					
					if (nick.getText().length()>3) {
						
						nick.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						setNickOk(true);
						
					} else {
						
						nick.setBorder(BorderFactory.createLineBorder(Color.RED));
						setNickOk(false);
						
						}
					
					
					if (nom_usuario.getText().length()>2) {
						
						nom_usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						setNomOk(true);
						
					} else {
						
						nom_usuario.setBorder(BorderFactory.createLineBorder(Color.RED));
						setNomOk(false);
						
						
						}		
					
					if (correo.getText().equals(correo2.getText()) && !correo.getText().isEmpty()) {
												
						
						correo.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						correo2.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						setMailOk(true);
						
								
					} else {
						
						
						correo.setBorder(BorderFactory.createLineBorder(Color.RED));
						correo2.setBorder(BorderFactory.createLineBorder(Color.RED));
						setMailOk(false);
						
						
						}
					
					
					if (password.getText().equals(password2.getText()) && !password.getText().isEmpty()) {
						
						password.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						password2.setBorder(BorderFactory.createLineBorder(Color.GREEN));
						setPassOk(true);
						
					} else {
						
				password.setBorder(BorderFactory.createLineBorder(Color.RED));
						password2.setBorder(BorderFactory.createLineBorder(Color.RED));
						setPassOk(false);
						
						}
					
					if (acepto.isSelected()) {
						setAceptoOk(true);
					} else {
						setAceptoOk(false);
					
					}
					
				
				if (isNickOk() && isNomOk() && isMailOk() && isPassOk() && isSiOk() && aceptoOk) {
					
					botonRegistro.setVisible(true);
				} else {
					
					botonRegistro.setEnabled(false);
					
			}
				
				acepto.addActionListener(new ActionListener () {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (acepto.isSelected()) {
							botonRegistro.setEnabled(true);
						} else {
							botonRegistro.setEnabled(false);
						
						}
					}
					
				}); 
				
			}
		};
				
				
			correo.addKeyListener(comprobador);
			correo2.addKeyListener(comprobador);
			password.addKeyListener(comprobador);
			password2.addKeyListener(comprobador);
			nom_usuario.addKeyListener(comprobador);
			nick.addKeyListener(comprobador);
	
		
			correo.addFocusListener(new FocusListener() {
	            
	            public void focusGained(FocusEvent e) {
	                // No es necesaria acción cuando "correo" gana el foco, pero es necesario implementar el método.
	            }
	            
	            public void focusLost(FocusEvent e) {
	            	validar = ValidaMail.validate(correo.getText());
	            	if (!validar) {
	            		
	            		JOptionPane.showMessageDialog(null, "El correo electrónico es incorrecto.");
	            		
	            	}
	            	
	            }
	        });
					
				botonAcceso.addActionListener(new ActionListener () {
					
					public void actionPerformed (ActionEvent e) {
						
						VentanaTerminos condiciones=new VentanaTerminos();
						LaminaTerminos term=new LaminaTerminos();
						condiciones.add(term);
						condiciones.setVisible(true);
											
					}
				});
				
				botonRegistro.addActionListener(new ActionListener () {
					public void actionPerformed (ActionEvent e) {
												
						ComprobarNick esonoes=new ComprobarNick(nick);
						ComprobarCorreo correoSi=new ComprobarCorreo(correo);
									
						if (!correoSi.compruebaCorreo()) {
							
							JOptionPane.showMessageDialog(correo, "Ese correo electrónico ya existe en nuestra base de datos, elige otro o inicia sesión con él.");
							
						}
							else if (esonoes.compruebaNick()==1) {
								
								JOptionPane.showMessageDialog(nick, "Ese nick ya existe en nuestra base de datos, elige otro");
							} else {
							
								RegistrarUsuario user=new RegistrarUsuario(nick, nom_usuario,
									ape1, ape2, correo, password, autor);
						
							user.registrarUsuario();
							
							JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaRegistro.this);
			                frame.dispose();
						
						}	
		
					}
					
					
				});
			
			//Ubicación de los items en sus espacios
			
			setLayout (new GridLayout (12, 2));
			add(regNick);
			add(nick);
			add(regNombre);
			add(nom_usuario);
			add(regApe1);
			add(ape1);
			add(regApe2);
			add(ape2);
			add(email1);
			add(correo);
			add(email2);
			add(correo2);
			add(pass1);
			add(password);
			add(pass2);
			add(password2);
			add(queSoy);
			add(autor);
			add(blanco);
			add(lector);
			add(botonAcceso);
			add(acepto);
			add(blanco2);
			add(botonRegistro);
			
		}
		
		private JButton botonRegistro;
		private JTextField nick;
		private JTextField nom_usuario;
		private JTextField correo, correo2;
		private JTextField ape1;
		private JTextField ape2;
		private JPasswordField password, password2;
		private JCheckBox acepto;
		private boolean validar;
		private boolean mailok;
		private boolean passok;
		private boolean alias;
		private boolean nombre;
		private JRadioButton autor;
		private boolean aceptoOk;
		private boolean nickOk;
		private boolean nomOk;
		private boolean mailOk;
		private boolean passOk;
		private boolean siOk;

		
			
		public JButton getBotonRegistro() {
			return botonRegistro;
		}



		public void setBotonRegistro(JButton botonRegistro) {
			this.botonRegistro = botonRegistro;
		}



		public JTextField getNick() {
			return nick;
		}



		public void setNick(JTextField nick) {
			this.nick = nick;
		}



		public JTextField getNom_usuario() {
			return nom_usuario;
		}



		public void setNom_usuario(JTextField nom_usuario) {
			this.nom_usuario = nom_usuario;
		}



		public JTextField getCorreo() {
			return correo;
		}



		public void setCorreo(JTextField correo) {
			this.correo = correo;
		}



		public JTextField getCorreo2() {
			return correo2;
		}



		public void setCorreo2(JTextField correo2) {
			this.correo2 = correo2;
		}

		public JPasswordField getPassword() {
			return password;
		}

		public void setPassword(JPasswordField password) {
			this.password = password;
		}

		public JPasswordField getPassword2() {
			return password2;
		}

		public void setPassword2(JPasswordField password2) {
			this.password2 = password2;
		}

		public JCheckBox getAcepto() {
			return acepto;
		}

		public void setAcepto(JCheckBox acepto) {
			this.acepto = acepto;
		}



		public boolean isValidar() {
			return validar;
		}

		public void setValidar(boolean validar) {
			this.validar = validar;
		}

		public boolean isMailok() {
			return mailok;
		}

		public void setMailok(boolean mailok) {
			this.mailok = mailok;
		}



		public boolean isPassok() {
			return passok;
		}

		public void setPassok(boolean passok) {
			this.passok = passok;
		}

		public boolean isAlias() {
			return alias;
		}

		public void setAlias(boolean alias) {
			this.alias = alias;
		}

		public boolean isNombre() {
			return nombre;
		}

		public void setNombre(boolean nombre) {
			this.nombre = nombre;
		}
		
		public boolean isNickOk() {
			return nickOk;
		}

		public void setNickOk(boolean nickOk) {
			this.nickOk = nickOk;
		}

		public boolean isNomOk() {
			return nomOk;
		}

		public void setNomOk(boolean nomOk) {
			this.nomOk = nomOk;
		}

		public boolean isMailOk() {
			return mailOk;
		}

		public void setMailOk(boolean mailOk) {
			this.mailOk = mailOk;
		}

		public boolean isPassOk() {
			return passOk;
		}

		public void setPassOk(boolean passOk) {
			this.passOk = passOk;
		}

		public boolean isSiOk() {
			return siOk;
		}

		public void setSiOk(boolean siOk) {
			this.siOk = siOk;
		}

		public boolean isAceptoOk() {
			return aceptoOk;
		}

		public void setAceptoOk(boolean aceptoOk) {
			this.aceptoOk = aceptoOk;
		}
		
	}
