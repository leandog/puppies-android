class PuppyList
  include Gametel

  list_item(:sparky, :text => 'Sparky')
  list_item(:ruby_sue, :text => 'Ruby Sue')
  list_item(:magggie_mae, :text => 'Maggie Mae')

  def view_for(name)
    self.send "#{name.downcase.gsub(' ', '_')}_view"
  end
end
